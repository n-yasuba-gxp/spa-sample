package jp.co.gxp.sample.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jp.co.gxp.sample.backend.controller.model.Error;
import jp.co.gxp.sample.backend.controller.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-14T10:17:09.795664+09:00[Asia/Tokyo]")

@Validated
@Api(value = "pets", description = "the pets API")
@Controller
@RequestMapping("/api")
public class PedApiController {

    /**
     * GET /pets : List all pets
     *
     * @param limit How many items to return at one time (max 100) (optional)
     * @return A paged array of pets (status code 200)
     * or unexpected error (status code 200)
     */
    @ApiOperation(value = "List all pets", nickname = "listPets", notes = "", response = Pet.class, responseContainer = "List", tags = {"pets",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "A paged array of pets", response = Pet.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class)})
    @RequestMapping(value = "/pets",
        produces = {"application/json"},
        method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> listPets(@ApiParam(value = "How many items to return at one time (max 100)") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        List<Pet> pets = List.of(
            new Pet().id(1L).name("ポチ").tag("dog"),
            new Pet().id(2L).name("ねこ").tag("cat")
        );
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}
