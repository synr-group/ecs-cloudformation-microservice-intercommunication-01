package com.synr.user.mgmt.grpc.api.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.lognet.springboot.grpc.GRpcService;

import com.google.protobuf.Empty;
import com.synr.user.mgmt.dto.GroupDto;
import com.synr.user.mgmt.dto.UserDto;
import com.synr.user.mgmt.gen.proto.GroupObjectIDs;
import com.synr.user.mgmt.gen.proto.UserResponse;
import com.synr.user.mgmt.gen.proto.UserType;
import com.synr.user.mgmt.gen.proto.UsersRequestByObjectId;
import com.synr.user.mgmt.gen.proto.UsersRequestByUserNameAndPassword;
import com.synr.user.mgmt.gen.proto.UsersResponse;
import com.synr.user.mgmt.service.UserService;
import com.synr.user.mgmt.user.gen.proto.UserGrpc.UserImplBase;

import io.grpc.stub.StreamObserver;

@GRpcService

public class UserGrpcController extends UserImplBase {

	private UserService userService;

	public UserGrpcController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void deleteUser(UsersRequestByObjectId request, StreamObserver<Empty> responseObserver) {
		userService.delete(request.getObjectID());
		responseObserver.onNext(Empty.newBuilder().build());
		responseObserver.onCompleted();
	}

	@Override
	public void getAllUsers(Empty request, StreamObserver<UsersResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.getAllUsers(request, responseObserver);
	}

	@Override
	public void getUser(UsersRequestByUserNameAndPassword request, StreamObserver<UserResponse> responseObserver) {
		UserDto userDto = userService.findByUserNameAndPassword(request.getUserName(), request.getPassword());

		UserType userType = UserType.newBuilder().setUserName(userDto.getUserName())
				// TODO: Create UserDTO to UserType Converter and use it here!!!!
				.build();

		UserResponse response = UserResponse.newBuilder().setObjectID(userDto.getObjectID()).setUser(userType).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void saveUser(UserType request, StreamObserver<UserResponse> responseObserver) {

		UserDto userDto = new UserDto();
		ConvertUserTypeToDto(request, userDto);

		UserDto userObject = userService.save(userDto);
		UserResponse response = UserResponse.newBuilder().setObjectID(userObject.getObjectID()).build();
		// TODO: Create UserDTO to UserType Converter and use it here!!!!

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void updateUser(UserType request, StreamObserver<UserResponse> responseObserver) {

		UserDto userDto = new UserDto();
		ConvertUserTypeToDto(request, userDto);

		UserDto userObject = userService.update(userDto);
		UserResponse response = UserResponse.newBuilder().setObjectID(userObject.getObjectID()).build();
		// TODO: Create UserDTO to UserType Converter and use it here!!!!

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	private void ConvertUserTypeToDto(UserType request, UserDto userDto) {

		userDto.setBlockSign(request.getBlockSign());
		userDto.setCity(request.getCity());
		userDto.setCountry(request.getCountry());
		userDto.setDepartment(request.getDepartment());
		userDto.setFirstName(request.getFirstName());
		// userDto.setId(request.get);
		userDto.setJobTitle(request.getJobTitle());
		userDto.setLastName(request.getLastName());
		userDto.setLastUsageLocation(request.getLastUsageLocation());
		userDto.setMobilePhone(request.getMobilePhone());
		userDto.setName(request.getName());
		// userDto.setObjectID(request.get);
		userDto.setOfficePhone(request.getOfficePhone());
		userDto.setPassword(request.getPassword());
		userDto.setPhysicalDeliveryOfficeName(request.getPhysicalDeliveryOfficeName());
		userDto.setPostalCode(request.getPostalCode());
		userDto.setState(request.getState());
		userDto.setStreetAddress(request.getStreetAddress());
		userDto.setUserName(request.getUserName());

		Set<GroupObjectIDs> collect = request.getGroupObjectIDsList().stream().collect(Collectors.toSet());

		request.getGroupObjectIDsList().stream().forEach(groupObjectID -> {
			GroupDto groupDto = new GroupDto();
			groupDto.setObjectID(groupObjectID.getObjectID());
			userDto.getGroups().add(groupDto);
		});
	}

}
