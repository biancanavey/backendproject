com.example.demo.Ward;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/Ward")

public class WardController {
    @GetMapping
    public List<Ward> listWard() {
        return wardService.getWard();
    } //Is there a list of wards ?

    // i.e localhost:8080/api/ward
    @GetMapping("{wardId}")
    public Ward getWardById(@PathVariable("wardId") String wardId) {
        /*
            TODO: Find and return wardID in db if not present throw new WardNotFoundException("message - Ward not found");
            Note that business logic should be in WardService
         */
        return (Ward) wardService.getWard();
    }


    @PostMapping
    public void addWard(@RequestBody Ward ward) {
        System.out.println(ward);
        wardService.addNewWard(ward);
    }

    // i.e DELETE localhost:8080/api/ward/12
    @DeleteMapping("{wardId}")
    public void deleteWard(@PathVariable("wardId") String wardId) {
        // TODO: Implement delete ward
        wardService.deleteWard(wardId);
    }

    //Updates ward name
    @PutMapping
    public void updateWard(@RequestBody Ward ward)  {
        wardService.updateWard(ward);
    }

}



}

