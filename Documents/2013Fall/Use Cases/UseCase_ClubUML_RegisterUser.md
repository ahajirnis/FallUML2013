#Register New Account Use Case#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.1</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>Spring 2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Spring 2013 Team</TD></TR>
<TR><TD>10.14.2013</TD><TD>1.1</TD><TD>Updated for user roles.</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how a user registers a new account with ClubUML.

## Actors ##

1 User
2 Relational Database

## Preconditions##

The User has a turned-on computer with internet access and a browser installed.

The User does not currently have an account with ClubUML.

##Basic Flow of Events##

1. The use case begins when the User opens a web browser, inputs the address of ClubUML, and hits enter.
2. The User clicks the “register’ link
3. The web page prompts the user for a user name, password, a repeat of the password, an email address, a security
question and finally the security question answer.  The user also selects a user role, either a
developer (regular user) or policy manager (administrator).

4. The User fills in all of the fields, and then clicks submit.
5 app will provide three pre define question to the user and user needs to choose any of them from the drop down
box

6.User need to enter a answer into the security answer field
7. The username and password are sent to the ClubUML server, verified, and stored in a database.
8 app will shore security question and the corresponding answer to the database
9. The web page tells the User that the account has been successfully created.
10. The web page prompts the User to log in.
11. The use case ends successfully.

##Alternative Flows##

###Invalid Username###

If in step 5 of the basic flow the username does not meet the username requirements (see WC-1), then

1. The web page prompts the user that the username does not meet a requirement, and which.
2. The web page clears all fields.
3. The use case ends with a failure condition.

###User Name Already Exists###

If in step 5 of the basic flow the username is found to already exist, then

1. The web page prompts the User that the username already exists.
2. The web page clears all fields.
3. The use case ends with a failure condition.

###Invalid Password###

If in step 5 of the basic flow the password does not meet the password requirements (see WC-2), then

1. The web page prompts the user that the password does not meet a requirement, and which.
2. The web page clears all fields.
3. The use case ends with a failure condition.

###Passwords Don’t Match###

If in step 5 of the basic flow the password and the repeat password do not match, then

1. The web page prompts the user that the password and the repeat password do not match.
2. The web page clears the password and repeat password.
3. The use case ends with a failure condition.

###Cancel###

If in any step before step 4 the User presses cancel, then

1. The web page will return to the home page.
2. The use case ends.

###Empty Field###

If in step 4, any of the fields are not filled in, then

1. The web page prompts the user that the offending field is empty, and is required to proceed.
2. The web page retains all other fields filled in. The submit button will not work until field is filled in.
3. The use case continues when the field is filled in.

##Key Scenarios##

1 User Name Already Exists

##Post-conditions##

###Successful Completion###

The user has created an account and is able to login.

###Failure Condition###

No new account has been created.

##Special Requirements##

[SpReq:WC-1] The username shall be 1-6 characters long, with only the following characters [a-zA-Z0-9]
[SpReq2:WC-2] The password shall be 6-10 characters long, with only the following characters
[a-zA-Z0-9].