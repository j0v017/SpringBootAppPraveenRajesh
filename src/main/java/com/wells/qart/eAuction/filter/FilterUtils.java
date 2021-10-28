package com.wells.qart.eAuction.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.wells.qart.eAuction.dto.DislikeDto;
import com.wells.qart.eAuction.dto.LikeDto;
import com.wells.qart.eAuction.dto.SellerDto;

public class FilterUtils {

	public static List<SellerDto> applyAgeFilter(List<SellerDto> filteredUsers, ArrayList<?> values) {
		int startAge = (Integer) values.get(0);
		int endAge = (Integer) values.get(1);
		List<SellerDto> ageFiltered = new ArrayList<SellerDto>();
		filteredUsers.forEach(user -> {
			if (user.getAge() >= startAge && user.getAge() <= endAge) {
				ageFiltered.add(user);
			}
		});
		return ageFiltered;
	}

	public static List<SellerDto> applyLocationFilter(List<SellerDto> filteredUsers, ArrayList<?> values, boolean byCity) {
		String location = values.get(0).toString();
		List<SellerDto> locationFiltered = new ArrayList<>();
		filteredUsers.forEach(user -> {
			String userLocation = byCity ? user.getCity() : user.getCountry();
			if (userLocation.equalsIgnoreCase(location)) {
				locationFiltered.add(user);
			}
		});
		return locationFiltered;
	}

	public static List<SellerDto> applyGenderFilter(List<SellerDto> filteredUsers, ArrayList<?> values) {
		String gender = values.get(0).toString();
		List<SellerDto> genderFiltered = new ArrayList<>();
		filteredUsers.forEach(user -> {
			String userSex = user.getGender();
			if (userSex.equals(gender)) {
				genderFiltered.add(user);
			}
		});
		return genderFiltered;
	}

	public static List<SellerDto> filterLikedUsers(List<SellerDto> filteredUsers, List<LikeDto> likes) {
		Set<Long> userIdSet = new HashSet<Long>();
		filteredUsers.forEach(user -> userIdSet.add(user.getUserId()));
		likes.forEach(like -> {
			if (userIdSet.contains(like.getLikedUserId())) {
				userIdSet.remove(like.getLikedUserId());
			}
		});
		filteredUsers = filteredUsers.stream().filter(user -> userIdSet.contains(user.getUserId()))
				.collect(Collectors.toList());
		return filteredUsers;
	}

	public static List<SellerDto> filterDislikedUsers(List<SellerDto> filteredUsers, List<DislikeDto> dislikes) {
		Set<Long> userIdSet = new HashSet<Long>();
		filteredUsers.forEach(user -> userIdSet.add(user.getUserId()));
		dislikes.forEach(like -> {
			if (userIdSet.contains(like.getDislikedUserId())) {
				userIdSet.remove(like.getDislikedUserId());
			}
		});
		filteredUsers = filteredUsers.stream().filter(user -> userIdSet.contains(user.getUserId()))
				.collect(Collectors.toList());
		return filteredUsers;
	}
}