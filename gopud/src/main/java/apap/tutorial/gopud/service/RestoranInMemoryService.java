package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoranInMemoryService implements RestoranService{
    private List<RestoranModel> listRestoran;

    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public void addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        for (RestoranModel restoran : getRestoranList()) {
            if (restoran.getIdRestoran().equals(idRestoran)) {
                return Optional.of(restoran);
            }
        }
        return null;
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        return null;
    }

    @Override
    public boolean deleteRestoran(RestoranModel restoranModel) {
        return true;
    }


    public RestoranModel getRestoranByNama(String nama) {
        for (RestoranModel restoran : getRestoranList()) {
            if (restoran.getNama().equals(nama)) {
                return restoran;
            }
        }
        return null;
    }


    public RestoranModel getRestoranByAlamat(String alamat) {
        for (RestoranModel restoran : getRestoranList()) {
            if (restoran.getAlamat().equals(alamat)) {
                return restoran;
            }
        }
        return null;
    }


    public RestoranModel getRestoranByNomorTelepon(Integer no) {
        for (RestoranModel restoran : getRestoranList()) {
            System.out.println(restoran.getNomorTelepon());
            if (restoran.getNomorTelepon().equals(no)) {
                return restoran;
            }
        }
        return null;
    }


    public void deleteRestoran(String idRestoran) {
        int x;
        for (x = 0; x < getRestoranList().size(); x++) {
            if (getRestoranList().get(x).getIdRestoran().equals(idRestoran)) {
                break;
            }
        }
        getRestoranList().remove(x);
    }
}
