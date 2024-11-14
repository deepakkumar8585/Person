package com.sp.main.service;

import com.sp.main.entity.Kyc;
import com.sp.main.entity.User;
import com.sp.main.payload.KycDto;
import com.sp.main.payload.UserDto;
import com.sp.main.repository.KycRepository;
import com.sp.main.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserKycService {

    private UserRepository userRepository;
    private KycRepository kycRepository;
    private ModelMapper modelMapper;

    public UserKycService(UserRepository userRepository, KycRepository kycRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.kycRepository = kycRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User save = userRepository.save(user);
        UserDto userDto1 = mapToDto(save);
        return userDto1;
    }

    public KycDto kycHere(KycDto kycDto, long userId) {
        User user = userRepository.findById(userId).get();
        Kyc kyc = mapToEntity(kycDto);
        kyc.setUser(user);
        Kyc saveKyc = kycRepository.save(kyc);
        KycDto kycDto1 = mapToDto(saveKyc);
        return kycDto1;
    }


    public UserDto mapToDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
        return user;
    }


    public KycDto mapToDto(Kyc kyc){

        KycDto kycDto = modelMapper.map(kyc, KycDto.class);
//        KycDto kycDto = new KycDto();
//        kycDto.setId(kyc.getId());
//        kycDto.setPanNumber(kyc.getPanNumber());
//        kycDto.setMobile(kyc.getMobile());
        return kycDto;
    }

  public Kyc  mapToEntity(KycDto kycDto){
        Kyc kyc = modelMapper.map(kycDto, Kyc.class);
//        Kyc kyc = new Kyc();
//        kyc.setId(kycDto.getId());
//        kyc.setMobile(kycDto.getMobile());
//        kyc.setPanNumber(kycDto.getPanNumber());
        return kyc;
    }



    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found with id " + id));
        return mapToDto(user);

    }


    public List<User> getAllUser(int pageSize , int pageNumber , String sortBy, String sortDir) {
        Pageable page = PageRequest.of(pageSize, pageNumber , Sort.by(sortBy));

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(Sort.Direction.ASC, sortBy) : Sort.by(Sort.Direction.DESC, sortBy);

        Page<User> allPage = userRepository.findAll(page);
        List<User> user = allPage.getContent();
        return user;
    }


}
