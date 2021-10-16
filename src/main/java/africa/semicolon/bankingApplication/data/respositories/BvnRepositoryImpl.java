package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Bvn;

import java.util.ArrayList;
import java.util.List;

public class BvnRepositoryImpl implements BvnRepository {
    List<Bvn> bvns =new ArrayList<>();


    @Override
    public Bvn save(Bvn bvn) {
        bvns.add(bvn);
        return findBvnById(bvn.getId());
    }

    @Override
    public Bvn findBvnById(String id) {
        for (Bvn bvn: bvns) {
            if(bvn.getId().equalsIgnoreCase(id)){
                return bvn;
            }

        }
        return null;
    }

    @Override
    public void deleteBvn(String id) {
        Bvn bvn = findBvnById(id);
        bvns.remove(bvn);

    }

    @Override
    public List<Bvn> findAllBvn() {
        return bvns;
    }
}
