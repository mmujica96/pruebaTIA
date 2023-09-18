package com.api.tia.services.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tia.models.User;
import com.api.tia.models.Dto.UserDto;
import com.api.tia.repositories.UserRepository;
import com.api.tia.services.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.modelMapper.map(userDto, User.class);
		return this.modelMapper.map(this.userRepository.save(user), UserDto.class);
	}

	@Override
	public List<UserDto> fetchUserList() {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.userRepository.findAll(), new TypeToken<List<UserDto>> () {}.getType());
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.modelMapper.map(userDto, User.class);
		User userExists = userRepository.getById(userId);
		user.setPassword(userExists.getPassword());
		return this.modelMapper.map(this.userRepository.save(user), UserDto.class);
	}

	@Override
	public void deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}

	@Override
	public List<UserDto> findByMail(String mail) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.userRepository.findByMail(mail), new TypeToken<List<UserDto>> () {}.getType());
	}

	@Override
	public List<UserDto> findByMailAndPassword(String mail, String pass) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.userRepository.findByMailAndPassword(mail, pass), new TypeToken<List<UserDto>> () {}.getType());
	}

	@Override
	public List<UserDto> findByIdentification(String identification) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.userRepository.findByIdentification(identification), new TypeToken<List<UserDto>> () {}.getType());
	}

}
