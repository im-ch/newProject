package jeff.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserCouponMapper {

	boolean createUserCoupon(@Param("userId") String userId, @Param("couponId") int couponId);

	void deleteUserCoupon(@Param("userId") String userId, @Param("couponId") int couponId);

	void useUserCoupon(@Param("userId") String userId, @Param("couponId") int couponId);

	List<Integer> selectUserCoupon(String userId);

}
