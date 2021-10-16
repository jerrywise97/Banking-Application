package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Bvn;

import java.util.List;

public interface BvnRepository {
    Bvn save(Bvn bvn);
    Bvn findBvnById(String id);
    void deleteBvn(String id);
    List<Bvn> findAllBvn();

}
