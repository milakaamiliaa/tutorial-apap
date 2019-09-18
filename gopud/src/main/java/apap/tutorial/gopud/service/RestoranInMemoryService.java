package apap.tutorial.gopud.service;

import java.util.ArrayList;
import java.util.List;
import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

@Service
public class RestoranInMemoryService implements RestoranService{
    private List<RestoranModel> listRestoran;

    public RestoranInMemoryService(){
        listRestoran = new ArrayList<>();
    }

    @Override
    public void addRestoran(RestoranModel restoran){
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

    @Override
    public RestoranModel getRestoranByIdRestoran(String IdRestoran){
        for(RestoranModel restoran : listRestoran){
            if(restoran.getIdRestoran().equals(IdRestoran)){
                return restoran;
            }
        }return null;
    }
}
