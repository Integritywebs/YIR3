package com.tiw.yir.network;

public class AppConstant {

    public interface BASEURL {
        String BASE_URL = "http://yir.yirkart.com/";
    }

    public interface ENDPOINT {

        // User Modules
        String LOGIN = "login";
        String REGISTER = "register";
        String CHANGE_PASSWORD = "changePassword";
        String FORGOT_PASSWORD = "forgotPassword";
        String RECOVER_FORGOT_PASSWORD = "recoverForgotPassword";

        // Group Modules
        String ADD_GROUP = "addGroup";
        String GET_LIST_OF_GROUP = "getListOfGroups";
        String JOIN_GROUP = "joinGroup";

        // Membership modules
        String ADD_MEMBERSHIP = "addMembership";
        String GET_MEMBERSHIP_LIST = "getMembershipList";

        // Scholarships Modules
        String ADD_SCHOLARSHIP = "addScholarship";
        String APPLY_FOR_SCHOLARSHIP = "applyForScholarship";
        String GET_LIST_OF_SCHOLARSHIP = "getListofScholarship";
        String GET_SCHOLARSHIP_AWARDS = "getScholarshipAwards";


        // Payment Modules
        String INITIATE_PAYMENT = "initiatePayment";


        //Elections Modules
        String APPLY_FOR_VOTE = "applyForVote";
        String CANDIDATE_LIST = "candidatesList";
        String GIVE_VOTE = "giveVote";
        String CALCULATE_RESULT = "calculateResult";








    }
}
