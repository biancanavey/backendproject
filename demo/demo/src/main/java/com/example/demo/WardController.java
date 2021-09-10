com.example.demo;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/ward")

public class WardController {
    @GetMapping
    public List<Ward> listWard() {
        return wardService.getWard();
    } //Is there a list of wards ?

    // i.e localhost:8080/api/ward
    @GetMapping("{wardName}")
    public Patient getWardByName(@PathVariable("wardName") String wardName) {
        /*
            TODO: Find and return wardName in db if not present throw new WardNotFoundException("message - Ward not found");
            Note that business logic should be in WardService
         */
        return (Ward) wardService.getWard();
    }


    @PostMapping
    public void addWard(@RequestBody Ward ward) {
        System.out.println(ward);
        wardService.addNewWard(ward); //Replace Patient Service
    }

    // i.e DELETE localhost:8080/api/ward/blueward
    @DeleteMapping("{wardName}")
    public void deleteWard(@PathVariable("wardName") String wardName) {
        // TODO: Implement delete ward
        wardService.deleteWard(wardName);
    }

    //Updates ward name
    @PutMapping
    public void updateWard(@RequestBody Ward ward) {
        wardService.updateWard(ward);
    }

}



}

