package ir.shajarkar.model.servcie;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.repository.BonusRepo;

import java.util.List;

public class BonusService {
    private BonusService() {
    }

    private final static BonusService PERSON_SERVICE = new BonusService();

    public static BonusService getInstance() {
        return PERSON_SERVICE;
    }

    public void save(Bonus bonus) {
        try (BonusRepo instance = BonusRepo.getInstance()) { //try-with-resource
            instance.save(bonus);
        }
    }

    public void update(Bonus bonus) {
        try (BonusRepo instance = BonusRepo.getInstance()) { //try-with-resource
            instance.update(bonus);
        }
    }

    public List<Bonus> getNotEmpty() {
        try (BonusRepo instance = BonusRepo.getInstance()) { //try-with-resource
           return instance.findMoreThanZeroCapacity();
        }
    }

    public List<Bonus> getAll() {
        try (BonusRepo instance = BonusRepo.getInstance()) { //try-with-resource
            return instance.findAll();
        }
    }
}
