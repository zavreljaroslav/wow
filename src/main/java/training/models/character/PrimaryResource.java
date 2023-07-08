package training.models.character;

import lombok.Getter;
import lombok.Setter;
import training.utils.Utils;

@Getter
@Setter
public class PrimaryResource {
    private int amount;
    private Utils.primaryResourceType primaryResourceType;
}
