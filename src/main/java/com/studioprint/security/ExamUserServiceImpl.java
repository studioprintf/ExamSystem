package com.studioprint.security;

import com.studioprint.dao.Exam_studentDao;
import com.studioprint.entity.ExamStudentEntity;
import com.studioprint.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucifer on 17-5-25.
 */
@Service
public class ExamUserServiceImpl implements UserDetailsService{

    @Autowired
    private UserManager userManager;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String studentID) throws UsernameNotFoundException {
        ExamStudentEntity examStudentEntity = userManager.user_login(studentID);
        if(examStudentEntity != null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("STUDENT"));
            return new User(
                    Integer.toString(examStudentEntity.getStudentId()),
                    examStudentEntity.getStudentPasswd(),true,true,true,true,
                    authorities);
        }
        throw new UsernameNotFoundException(
                "User '" + studentID + "' not found.");
    }
}
