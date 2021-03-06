package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

//BRONZE
//TODONE Add a Play Again button to the pages that end the game. It should go to the start page.
//TODONE Add a New Player button to the pages that end the game. It should go to the welcome page.
//TODONE Add an additional step in the northern route in between England and the current end page
//TODONE   In this middle step allow the player to continue north or return south
//TODONE   Make up your own description for this page. G rated please.

//SILVER
//TODONE Add a text box to the welcome page for the player to enter their name
//TODONE Inside the start method store the player name in session
//TODO On the game end pages change "The end." to say "The end for #playerName#."
//TODO Make the player lose one crew member due to injury on each turn.
//TODO   HINT: Store the number of able bodied crew in session
//TODO If the able bodied crew count drops below 5 before the game ends go to a
//TODO   "Took refuge on an island" end page
//TODO Get awesome G rated non-offensive pictures from the internet or elsewhere
//TODO   to add to each screen.
//TODO Store these pictures in the public/images folder

//GOLD
//TODO Make the western route have a "Meeting with Santa" page that
//TODO   the player has a 50% chance of seeing
//TODO On each screen show the list of able bodied crew and announce
//TODO   the name of the injured crew person
//TODO Consolidate the end game pages into a single page to reduce duplicate code
//TODO Add an Easter Egg (Google or use search engine of your choice for "Easter Egg Game"
//TODO   if an explanation is needed)

//PLATINUM
//TODO On the welcome screen allow the user to pick one of four pictures of a kitten
//TODO   to represent themselves.  Show this image on each screen of the game.
//TODO Implement a 20% chance that the fidget spinners are covered in lead paint
//TODO   When this happens the Queen should throw the player in prison

public class GameController extends Controller
{
    FormFactory formFactory;

    @Inject
    public GameController(FormFactory formFactory)
    {
        this.formFactory = formFactory;

    }

    public Result welcome()
    {
        return ok(views.html.welcome.render());
    }

    public Result start()
    {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        String name = dynamicForm.get("name");
        session().put("name", name);
        return ok(views.html.start.render(name));
    }

    public Result goEastFromEngland()
    {
        return ok(views.html.eastfromengland.render());
    }

    public Result goNorthFromEngland()
    {
        return ok(views.html.northfromengland.render());
    }

    public Result goWestFromEngland()
    {
        return ok(views.html.westfromengland.render());
    }

    public Result eastEnd()
    {
        String name = session().get("name");
        return ok(views.html.eastend.render(name));
    }

    public Result westEnd()
    {
        String name = session().get("name");
        return ok(views.html.westend.render(name));
    }

    public Result homePort()
    {
        return ok(views.html.homeport.render());
    }

    public Result kittens()
    {
        return ok(views.html.kittens.render());
    }

    public Result earlyNorth()
    {
        return ok(views.html.earlynorth.render());
    }


}

