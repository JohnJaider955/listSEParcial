package co.edu.umanizales.tads.controller;

import co.edu.umanizales.tads.controller.dto.ResponseDTO;
import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getKids(){
        return new ResponseEntity<>(new ResponseDTO(
                200,listSEService.getKids(),null), HttpStatus.OK);
    }

    //Buscar la id del niño
    @GetMapping(path = "/{code}")
    public ResponseEntity<ResponseDTO> getIdKid(String identification){
        return new ResponseEntity<>(new ResponseDTO(
                200,listSEService.forwardByPosition(identification),null), HttpStatus.OK);
    }

    //Método eliminar buscando la edad del niño
    @DeleteMapping(path = "/delete/{code}")
    public ResponseEntity<ResponseDTO> deleteKidByAge(@PathVariable String age)
    {
        Kid findKid = listSEService.deleteKidByAge(age);
        if(findKid == null)
        {
            return new ResponseEntity<>(new ResponseDTO(
                    404, "No existe un niño con esa edad", null
            ), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ResponseDTO(
                    200, "Niño(s) eliminados" +findKid, null
            ), HttpStatus.OK);
        }
    }

    //Método adelantar de posición
    @GetMapping(path = "/pass/{code}")
    public ResponseEntity<ResponseDTO> forwardByPosition(@PathVariable String position) {
        Kid findKid = listSEService.forwardByPosition(position);
        if(findKid == null)
        {
            return new ResponseEntity<>(new ResponseDTO(
                    404, "No existe un niño con esa identificación", null
            ), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ResponseDTO(
                    200, findKid, null
            ), HttpStatus.OK);
        }
    }
}

