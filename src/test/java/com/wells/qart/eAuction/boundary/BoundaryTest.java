//package com.wells.qart.eAuction.boundary;
//
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
////import com.iiht.training.datingapp.dto.*;
//import com.wells.qart.eAuction.dto.*;
//import com.wells.qart.eAuction.testutils.MasterData;
//import com.wells.qart.eAuction.testutils.TestUtils;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
////import org.junit.Test;
////import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//public class BoundaryTest {
//	private static Validator validator;
//
//	// ----------------------------------------------------------------------------------------------
//	@BeforeAll
//	public static void setUp() {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		validator = factory.getValidator();
//	}
//
//	@AfterAll
//	public static void afterAll() {
//		TestUtils.testReport();
//	}
//
//	@Test
//	public void testUserNameNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setName("");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserNameMinThree() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setName("Ab");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserNameMaxHundred() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		String name = "";
//		for (int i = 0; i < 120; i++) {
//			name.concat("A");
//		}
//		sellerDto.setName(name);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserAgeNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setAge(null);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserAgeMinEighteen() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setAge(10);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserAgeMaxSixty() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setAge(65);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserMobileNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setPhoneNumber(null);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserMobileMinTen() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setPhoneNumber(12345L);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserMobileMaxTen() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//
//		sellerDto.setPhoneNumber(123456789012L);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserGenderNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setGender("");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserEmailNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setEmail("");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserEmailMinThree() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setEmail("Ab");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserEmailMaxHundred() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		String name = "";
//		for (int i = 0; i < 120; i++) {
//			name.concat("A");
//		}
//		sellerDto.setEmail(name);
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserEmailValidFormat() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setEmail("abc");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserCityNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setCity("");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testUserCountryNotNull() throws Exception {
//		SellerDto sellerDto = MasterData.getUserDto();
//		sellerDto.setCountry("");
//		Set<ConstraintViolation<SellerDto>> violations = validator.validate(sellerDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsInterestedInNotNull() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setInterestedIn("");
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsInterestedInMinThree() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setInterestedIn("Ab");
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsInterestedInMaxHunderds() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		String interestedIn = "";
//		for (int i = 0; i < 120; i++) {
//			interestedIn.concat("A");
//		}
//		interestsDto.setInterestedIn(interestedIn);
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsNotInterestedInNotNull() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setNotInterestedIn("");
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsNotInterestedInMinThree() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setNotInterestedIn("Ab");
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsNotInterestedInMaxHunderds() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		String notInterestedIn = "";
//		for (int i = 0; i < 120; i++) {
//			notInterestedIn.concat("A");
//		}
//		interestsDto.setInterestedIn(notInterestedIn);
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsHobbiesNotNull() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setHobbies(null);
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//
//
//	@Test
//	public void testInterestsProfileUrlNotNull() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setProfileUrl(null);
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsAboutNotNull() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setAbout(null);
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsAboutMinThree() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		interestsDto.setAbout("Ab");
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testInterestsAboutMaxHunderd() throws Exception {
//		InterestsDto interestsDto = MasterData.getInterestsDto();
//		String about = "";
//		for (int i = 0; i < 120; i++) {
//			about.concat("A");
//		}
//		interestsDto.setAbout(about);
//		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testLikesUserIdNotNull() throws Exception {
//		LikeDto likeDto = MasterData.getLikeDto();
//		likeDto.setUserId(null);
//		Set<ConstraintViolation<LikeDto>> violations = validator.validate(likeDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testLikesLikedUserIdNotNull() throws Exception {
//		LikeDto likeDto = MasterData.getLikeDto();
//		likeDto.setLikedUserId(null);
//		Set<ConstraintViolation<LikeDto>> violations = validator.validate(likeDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testDislikeUserIdNotNull() throws Exception {
//		DislikeDto dislikeDto = MasterData.getDislikeDto();
//		dislikeDto.setUserId(null);
//		Set<ConstraintViolation<DislikeDto>> violations = validator.validate(dislikeDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testDislikeDislikedUserIdNotNull() throws Exception {
//		DislikeDto dislikeDto = MasterData.getDislikeDto();
//		dislikeDto.setDislikedUserId(null);
//		Set<ConstraintViolation<DislikeDto>> violations = validator.validate(dislikeDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testMatchUserIdNotNull() throws Exception {
//		MatchDto matchDto = MasterData.getMatchDto();
//		matchDto.setUserId(null);
//		Set<ConstraintViolation<MatchDto>> violations = validator.validate(matchDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//
//	@Test
//	public void testMatchMatchedUserIdNotNull() throws Exception {
//		MatchDto matchDto = MasterData.getMatchDto();
//		matchDto.setMatchedUserId(null);
//		Set<ConstraintViolation<MatchDto>> violations = validator.validate(matchDto);
//		TestUtils.yakshaAssert(TestUtils.currentTest(), !violations.isEmpty() ? true : false, TestUtils.boundaryTestFile);
//	}
//}
