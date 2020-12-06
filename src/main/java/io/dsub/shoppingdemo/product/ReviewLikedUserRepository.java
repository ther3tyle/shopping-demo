package io.dsub.shoppingdemo.product;

import io.dsub.shoppingdemo.model.ProductReview;
import io.dsub.shoppingdemo.model.ReviewLikedUser;
import io.dsub.shoppingdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewLikedUserRepository extends JpaRepository<ReviewLikedUser, Long> {
    ReviewLikedUser findByUserAndProductReview(User user, ProductReview review);
}
