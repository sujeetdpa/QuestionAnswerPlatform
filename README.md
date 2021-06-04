# QuestionAnswerPlatform
Backend APIs for a question answer platform, where questions and answers for  interviews of various companies are being
captured.

# API Documentation.
<h4>
    In order to use the apis the initial URL Pattern <br>
    If Running on local machine http://localhost:8080<br>
    If Running on Cloud http://ip_of_machine:8080<br>
</h4><br>
<h5>You can use Postman or any other application to make/test these apis</h5>
<br><br>
<ol type="1">
    <li>
        <h4>CRUD APIs For Company Entity.</h4>
        <ul>
            <li>Adding compnay<br>
                Request Type- POST
                Api- /compnay/add
                Headers- Content Type : application/json
                Body- {
                "name":"Company_Name"
                }
                Example: Body {
                "name":"Company123"
                }
            </li>
            <li>
                Updating Company Details<br>
                Request Type- PUT
                Api- /company/update/{company_id}
                Headers- Content Type : application/json
                Body- {
                "id":"Company id",
                "name":"Company_Name"
                }
                Example:
                Api- /company/update/1
                Body{
                "id":"1",
                "name":"Company456"
                }
            </li>
            <li>
                Deleting Company Details<br>
                Request Type- DELETE
                Api- /company/delete/{company_id}
                Example: Api- /company/delete/1
            </li>
            <li>
                Getting Company Details<br>
                Request Type- GET
                Api- /company/{company_id}
                Example: Api- /company/1
            </li>
            <li>
                Getting List of all Company <br>
                Request Type- GET
                Api- /company/all
            </li>
        </ul>
    </li>
    <li>
        <h4>CRUD APIs for SubTopic Entity</h4><br>
        <ul>
            <li>
                Adding SubTopic <br>
                Request Type- POST
                Api- /subtopic/add
                Headers- Content Type : application/json
                Body- {

                "name":"SubTopic Name",
                "topic":{
                "id":"Topic_Id",
                "name": "Topic_Name"
                }
                }
                Example:
                Body- {
                "name":"Stack",
                "topic":{
                "id":"1",
                "name": "Data Structure"
                }
                }
            </li>
            <li>
                Updating SubTopic Details<br>
                Request Type- PUT
                Api- /subtopic/update/{subtopic_id}
                Headers- Content Type : application/json
                Body- {
                "id":"SubTopic_id",
                "name":"SubTopic Name",
                "topic":{
                "id":"Topic_Id",
                "name": "Topic_Name"
                }
                }
                Example:
                Api- /subtopic/update/1
                Body- {
                "id":"1",
                "name":"Queue", // changes Stack to Queue
                "topic":{
                "id":"1",
                "name": "Data Structure"
                }
                }
            </li>
            <li>
                Deleting SubTopic Details<br>
                Request Type- DELETE
                Api- /subtopic/delete/{subtopic_id}
                Example: Api- /subtopic/delete/1
            </li>
            <li>
                Getting SubTopic Details<br>
                Request Type- GET
                Api- /subtopic/{subtopic_id}
                Example: Api- /subtopic/1
            </li>
            <li>
                Getting List of all SubTopic <br>
                Request Type- GET
                Api- /subtopic/all
            </li>
        </ul>
    </li>
    <li>
        <h4>CRUD APIs for Topic Entity</h4><br>
        <ul>
            <li>
                Adding Topic <br>
                Request Type- POST
                Api- /topic/add
                Headers- Content Type : application/json
                Body- {
                "name":"Topic_Name"
                }
                Example:
                Body- {
                "name":"Data Structure"
                }
            </li>
            <li>
                Updating Topic Details<br>
                Request Type- PUT
                Api- /topic/update/{topic_id}
                Headers- Content Type : application/json
                Body- {
                "id":"Topic_id",
                "name":"Topic_name"
                }
                Example:
                Api- /topic/update/1
                Body- {
                "id":"1",
                "name":"Algorithm" //Changes Data Structure to Algorithm
                }
            </li>
            <li>
                Deleting Topic Details<br>
                Request Type- DELETE
                Api- /topic/delete/{topic_id}
                Example: Api- /topic/delete/1
            </li>
            <li>
                Getting Topic Details<br>
                Request Type- GET
                Api- /topic/{topic_id}
                Example: Api- /topic/1
            </li>
            <li>
                Getting List of all Topic <br>
                Request Type- GET
                Api- /topic/all
            </li>
        </ul>
    </li>
    <li>
        <h4>CRUD APIs for Tag Entity</h4>
        <ul>
            <li>
                Adding Tag <br>
                Request Type- POST
                Api- /tag/add
                Headers- Content Type : application/json
                Body- {
                "name":"Tag_Name"
                }
                Example:
                Body- {
                "name":"O(n)"
                }
            </li>
            <li>
                Updating Tag Details<br>
                Request Type- PUT
                Api- /tag/update/{tag_id}
                Headers- Content Type : application/json
                Body- {
                "id":"Tag_id",
                "name":"Tag_name"
                }
                Example:
                Api- /tag/update/1
                Body- {
                "id":"1",
                "name":"O(logn)" //changes O(n) to O(logn)
                }
            </li>
            <li>
                Deleting Tag Details<br>
                Request Type- DELETE
                Api- /tag/delete/{tag_id}
                Example:
                Api- /tag/delete/1
            </li>
            <li>
                Getting Tag Details<br>
                Request Type- GET
                Api- /tag/{tag_id}
                Example:
                Api- /tag/1
            </li>
            <li>
                Getting List of all Tag <br>
                Request Type- GET
                Api- /tag/all
            </li>
        </ul>
    </li>
    <li>
        <h4>CRUD APIs for User Entity</h4>
        <ul>
            <li>
                Adding User <br>
                Request Type- POST
                Api- /user/add
                Headers- Content Type : application/json
                Body- {
                "name":"User_Name"
                }
                Example:
                Body- {
                "name":"Robert Hank"
                }
            </li>
            <li>
                Updating User Details<br>
                Request Type- PUT
                Api- /user/update/{user_id}
                Headers- Content Type : application/json
                Body- {
                "id":"User_id",
                "name":"User_name"
                }
                Example:
                Api- /user/update/1
                Body- {
                "id":"1",
                "name":"Robert Flask" //Changes Robert Hank to Robert Flask
                }
            </li>
            <li>
                Deleting User Details<br>
                Request Type- DELETE
                Api- /user/delete/{user_id}
                Example: Api- /user/delete/1
            </li>
            <li>
                Getting User Details<br>
                Request Type- GET
                Api- /user/{user_id}
                Example: Api- /user/1
            </li>
            <li>
                Getting List of all User <br>
                Request Type- GET
                Api- /user/all
            </li>
        </ul>
    </li>
    <li>
        <h4>APIs for operation on Question</h4>
        <ul>
            <li>
                Adding Question<br>
                Request Type- POST
                Api- /question/add
                Headers- Content Type: application/json
                Body- {
                "text":"Question_text",
                "companyid":"Id of company posting the question",
                "subtopicid":"SubTopic_id to which question belong",
                "tags":["list of name of tags"],
                "userid":"userid of user posting the question"
                }
                Example:
                Body- {
                "text":"What is LinkList?",
                "companyid":"1",
                "subtopicid":"1",
                "tags":["1","2"],
                "userid":"1"
                }
            </li>
            <li>
                Getting Details of Question<br>
                Request Type- GET
                Api- /question/{question_id}
                Example: Api- /question/1
            </li>
            <li>
                Like a question<br>
                Request Type- POST
                Api- /question/like
                Params- questionid=id_of_question_to_be_liked & userid=id_of_user_like_question
                Example: Api- /question/like?questionid=1&userid=3
            </li>
            <li>
                Filtering the Question<br>
                Request Type- GET
                Api- /question/filter
                Headers- Content Type : application/json
                Body- {
                "companies":["list_of_id_of_company_to_filter_the_question"],
                "subtopics":["list_of_id_of_subtopic_to_filter_the_question"],
                "likes":"number_of_likes",
                "date": "yyyy-mm-dd",
                "tags":["list_of_id_of_tags_to_filter_the_question"]
                }
                Example:
                Body- {
                "companies":["1","2"],
                "subtopics":["1","3"],
                "likes":"500",
                "date": "2021-03-04",
                "tags":["1","2"]
                }
            </li>

        </ul>
    </li>
    <li>
        <h4>APIs for operation on Answers</h4>
        <ul>
            <li>
                Posting answer to a question<br>
                Request Type- POST
                Api- /answer/add
                Headers- Content Type: application/json
                Body- {
                "text":"answer_text",
                "questionid":"id_of_question_for_which_answer_is_post",
                "userid":"userid_of_user_posting_the_answer"
                }
                Example:
                Body- {
                "text":"LinkList is Data Structure formed by joining many nodes",
                "questionid":"1",
                "userid":"1"
                }
            </li>
            <li>
                Commenting on answer<br>
                Request Type- POST
                Api- /answer/comment/add
                Headers- Content Type: application/json
                Body- {
                "text":"comment_text",
                "answerid":"answer_id_for_which_comment_is_being_post",
                "userid":"userid_of_user_posting_the_comment"
                }
                Example:
                Body- {
                "text":"There is some error int the answer",
                "answerid":"1",
                "userid":"2"
                }
            </li>
            <li>
                Like a Answer<br>
                Request Type-POST
                Api- /answer/like
                Params- answerid=answer_id_of_answer_to_be_liked & userid=id_of_user_like_answer
                Example: /answer/like?answerid=1&userid=2
            </li>
        </ul>
    </li>
</ol>
