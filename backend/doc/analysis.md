###Function
* the server receives data from the quadrotor 
* saves it on the server
* analyses it
* and presents the raw data with the analysed result on a web when called upon

That's a few classes

###Class
* Parser: parse the xml to data
* Report: the set of env data at a certain time point(model)
* Statistician: calculates the statistics
* DAO: deals with data persistence
* Controller for webpage: prepares the data for presentation


####Parser
* Report getData( *Xml* )
* 