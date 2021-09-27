package tagging;

import javax.annotation.*;
import javax.annotation.meta.*;
import java.lang.annotation.*;

@Nonnull
@TypeQualifierDefault({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
public @interface NonNullApi {
}