package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.Review;
import com.jaguar.model.ReviewCollection;
import com.jaguar.net.ApiResource;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ReviewTest extends BaseJaguarTest {
  public static final String REVIEW_ID = "prv_123";

  private Review getReviewFixture() throws JaguarException {
    final Review review = Review.retrieve(REVIEW_ID);
    resetNetworkSpy();
    return review;
  }

  @Test
  public void testApprove() throws JaguarException {
    final Review review = getReviewFixture();

    review.approve();
    assertNotNull(review);
    verifyRequest(
        ApiResource.RequestMethod.POST, String.format("/v1/reviews/%s/approve", review.getId()));
  }

  @Test
  public void testList() throws JaguarException {
    final Map<String, Object> params = new HashMap<>();
    params.put("limit", 1);

    final ReviewCollection reviews = Review.list(params);

    assertNotNull(reviews);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/reviews"));
  }

  @Test
  public void testRetrieve() throws JaguarException {
    final Review review = Review.retrieve(REVIEW_ID);

    assertNotNull(review);
    verifyRequest(ApiResource.RequestMethod.GET, String.format("/v1/reviews/%s", review.getId()));
  }
}
