Synthesio4j
====

This is a very simple API wrapper for the Synthesio API, available here: http://api.synthesio.com/documentation/documentation.html

This wrapper may be somewhat incomplete.

Issues and TODOs
---
- There is no support for the Verbatim POST endpoint (http://api.synthesio.com/documentation/verbatim_post.html). However, Verbatim GET and all other endpoints are supported and return their data in parsed native Java data structures.
- There may be some edge cases, such as when a variable is null or not present, that aren't accounted for. The only null cases accounted for are those indicated in the API documentation and those present in the REST call examples given in the documentation.
- The user must manually build this project to a JAR to include it in their project. This project is already using Gradle for dependency management, so this should be a very simple step. Due to time constraints, this hasn't been implemented yet, but only a few changes to `build.gradle` should be needed.

Usage
---
- Create a new `Synthesio` object, supplying your API key to the constructor. Ex: `Synthesio syn = new Synthesio("myKey");`
- Use the `.makeApiCall()` method, supplying the class of the Endpoint that you would like to use. Example, to make a Verbatim GET API call: `VerbatimGet vg = syn.makeApiCall(VerbatimGet.class);`
- Set all parameters for the Endpoint object you just created. For example, to add a verbatim ID to your new Verbatim object: `vg.setVerbatimId(123456789L);`
- Call `.executeApiCall()` to return the API response once you have finished setting all of your parameters. Ex: `VerbatimGetResponse vgResponse = vg.executeApiCall();`
- Use the getter methods provided by the returned object to retrieve your API information
