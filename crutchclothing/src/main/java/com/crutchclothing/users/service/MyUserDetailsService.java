package com.crutchclothing.users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crutchclothing.users.dao.UserDao;
import com.crutchclothing.users.model.UserRole;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		com.crutchclothing.users.model.User user = userDao.findByUserNameWithRoles(username);
		
		//System.out.println("user = " + user.getUsername());
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		//System.out.println("Granted authorities size = " + authorities.size());
		for (GrantedAuthority grantedAuthority : authorities) {
			//System.out.println("granted authority = " + grantedAuthority.getAuthority());
		}

		return buildUserForAuthentication(user, authorities);
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.crutchclothing.users.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		//System.out.println("userRoles size = " + userRoles.size());
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			//System.out.println("user role = " + userRole.getRole());
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		
		//System.out.println("result size = " + Result.size());
		for (GrantedAuthority grantAuth : Result) {
			//System.out.println("granted authority = " + grantAuth.getAuthority());
		}

		return Result;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}