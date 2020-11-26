package spring.boot.parser.service.implementation;

import com.univocity.parsers.common.record.Record;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.parser.model.Product;
import spring.boot.parser.model.Review;
import spring.boot.parser.model.Role;
import spring.boot.parser.model.User;
import spring.boot.parser.service.ProductService;
import spring.boot.parser.service.RecordToDatabaseService;
import spring.boot.parser.service.ReviewService;
import spring.boot.parser.service.RoleService;
import spring.boot.parser.service.UserService;

@Log4j
@Service
public class RecordToDatabaseServiceImpl implements RecordToDatabaseService {
    public static final String USER_ID = "UserId";
    public static final String USER = "USER";
    public static final String PRODUCT_ID = "ProductId";
    public static final String PROFILE_NAME = "ProfileName";
    public static final String ID = "Id";
    public static final String HELPFULNESS_NUMERATOR = "HelpfulnessNumerator";
    public static final String HELPFULNESS_DENOMINATOR = "HelpfulnessDenominator";
    public static final String SCORE = "Score";
    public static final String TIME = "Time";
    public static final String SUMMARY = "Summary";
    public static final String TEXT = "Text";
    public static final String PASSWORD = "1111";
    private final ReviewService reviewService;
    private final UserService userService;
    private final ProductService productService;
    private final RoleService roleService;

    @Autowired
    public RecordToDatabaseServiceImpl(ReviewService reviewService,
                                       UserService userService,
                                       ProductService productService,
                                       RoleService roleService) {
        this.reviewService = reviewService;
        this.userService = userService;
        this.productService = productService;
        this.roleService = roleService;
    }

    @Override
    public void saveEntities(List<Record> records) {
        log.info("Starting to parse List<Record>");
        Set<User> userHashSet = new HashSet<>();
        Set<Product> productHashSet = new HashSet<>();

        for (Record row : records) {
            userHashSet.add(parseUser(row));
            productHashSet.add(parseProduct(row));
        }

        userService.saveAll(userHashSet);
        log.info("Saving of the users are successful!");

        productService.saveAll(productHashSet);
        log.info("Saving of the products are successful!");

        reviewService.saveAll(records.stream()
                .map(this::parseReview)
                .collect(Collectors.toList()));
        log.info("Saving of the reviews are successful!");
    }

    private User parseUser(Record row) {
        Set<Role> roleUserSet = new HashSet<>();
        roleUserSet.add(roleService.getRoleByRoleName(USER));
        return User.builder()
                .userId(row.getString(USER_ID))
                .profileName(row.getString(PROFILE_NAME))
                .password(PASSWORD)
                .role(roleUserSet)
                .build();
    }

    private Product parseProduct(Record row) {
        return Product.builder()
                .productId(row.getString(PRODUCT_ID))
                .build();
    }

    private Review parseReview(Record row) {
        User user = userService.getByUserId(row.getString(USER_ID));
        Product product = productService.getByProductId(row.getString(PRODUCT_ID));
        return Review.builder()
                .reviewId((row.getLong(ID)))
                .helpfulnessNumerator(row.getLong(HELPFULNESS_NUMERATOR))
                .helpfulnessDenominator(row.getLong(HELPFULNESS_DENOMINATOR))
                .score(row.getLong(SCORE))
                .time(row.getLong(TIME))
                .summary(row.getString(SUMMARY).trim())
                .text(row.getString(TEXT).trim())
                .user(user)
                .product(product)
                .build();
    }
}
