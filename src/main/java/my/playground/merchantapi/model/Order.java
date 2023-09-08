package my.playground.merchantapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("orders")
@Getter
@RequiredArgsConstructor
public class Order {
    @Id
    @Setter
    private final Long orderId;
    private final Long buyerId;
    private final LocalDateTime datePlaced;
    private final BigDecimal totalAmount;
    private final Long shippingAddressId;
    private final Long billingAddressId;
    private final Long paymentId;
}
