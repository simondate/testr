package controllers;
import static play.data.Form.form;

import java.util.List;

import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.*;
import models.*;
import views.html.*;

public class Application extends Controller {
	

    public static Result index() {
    	return ok(index.render("Testr"));
    }
    
//    public static Result createTest() {
//    	Test test = Form.form(Test.class).bindFromRequest().get();
//    	test.save();
//    	return ok(index.render(test.name));
//    } 
    
    public static Result createTest() {
    	Test test = Form.form(Test.class).bindFromRequest().get();
    	test.save();
        return ok(
            createTest.render(test)
        );
    } 
    
    public static Result getTests(){
    	List<Test> tests = new Model.Finder<>(long.class,Test.class).all();
    	return ok(Json.toJson(tests));
    }
    
    public static Result save() {
        Form<Test> testForm = form(Test.class).bindFromRequest();
//        if(testForm.hasErrors()) {
//            return badRequest(testForm.render(testForm));
//        }
        testForm.get().save();
        flash("success", "Computer " + testForm.get().name + " has been created");
        return ok(index.render("Testr"));
    }
    
  
    public static Result addQuestion(){ // creates
    	return TODO;
    }
    
    public static Result addAnswers(long questionID, String[] answers, boolean[]correct ){
    	return TODO;
    }
    
    
   

}
