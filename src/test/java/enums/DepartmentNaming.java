package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DepartmentNaming {
    PRODUCTS("Products"),
    CART("Your Cart");

    private final String displayName;
}
