package co.edu.umanizales.tads.service;

import co.edu.umanizales.tads.controller.dto.ResponseDTO;
import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.model.ListSE;
import co.edu.umanizales.tads.model.Node;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ListSEService {

    private List<Kid> kids;

    public ListSEService() {
        kids = new ArrayList<>();
        kids.add(new Kid("123","Carlos","3"));
        kids.add(new Kid("256","Mariana","4"));
        kids.add(new Kid("789","Daniel", "5"));

        //kids.addToStart(new Kid("967","Estefania","9");
    }

    //Se hace una búsqueda de la edad del niño
    public Kid deleteKidByAge(String age)
    {
        for(Kid kid:kids)
        {
            if(kid.getAge().equalsIgnoreCase(age))
            {
                return kid;
            }
        }
        return null;
    }

    //Se hace una búsqueda de la posición del niño
    public Kid forwardByPosition(String position)
    {
        for(Kid kid:kids)
        {
            if(kid.getIdentification().equalsIgnoreCase(position))
            {
                return kid;
            }
        }
        return null;
    }


}


