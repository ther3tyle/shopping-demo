package io.dsub.shoppingdemo.product;

import io.dsub.shoppingdemo.model.Product;
import io.dsub.shoppingdemo.model.ProductReview;
import io.dsub.shoppingdemo.model.ReviewLikedUser;
import io.dsub.shoppingdemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ReviewLikedUserRepository reviewLikedUserRepository;
    private final ProductRepository productRepository;

    public List<ReviewDTO> checkUserLikedReview(User user){
        Product product = new Product();
        return product.getReviews().stream()
                .map(rev -> {
                    ReviewDTO dto = new ReviewDTO();
                    /* way to fix the many to many */
                    ReviewLikedUser reviewLikedUser = reviewLikedUserRepository.findByUserAndProductReview(user, rev);
                    dto.setLike(reviewLikedUser != null);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
