# Observable Collections
Observable Collectons for Android Kotlin apps. 
Observes adds, deletes etc.
Callback is trigged for each action that changes the contents of the collection.

## Getting Started

This is a library project and should be downloaded and added as a module in your application.

### Prerequisites

Android Studio
Kotlin

### Installing

Download the zip file and unpack into your project directory.
```
Go to File->Project Structure.
Ensure that the module is included in the moduels of the application.

Go to the Dependecies tab and and click on the "+" sign. Select Module Dependency.
From the list of modules select "ObservableCollections"
```

A Gradle version is not available at present.

## Usage

Usage is simple and is the same as other LiveData.
Just "Observe" the object as you would any other.
The observer will receive the collection object as the parameter when called.

You can check to object to to what action was performed that caused the change, what was passed to it and what was the result.
The following properties are available from the collection object:
```
action: The action performed. A full list is available in the enum ObservableCollectionsAction
actionElement: Element on which the action was performed. For example, the element that was passed to an add or delete method
actionElements: Element collection on which the action was performed. For example, the collection passed to an addall method
actionInt: Int value on which the action was performed. For example, the int value passed to a removeAt method
resultElement: The element returned from the method. For example, the element returned from a pop method
resultBoolean: Boolean returned from the method. For example, boolean returned from an add method. Note that this will always be true if it is not null
resultInt: Int returned from the method. For example, the number of elements deleted in a drainTo method
```
The properties will only have relevant values. If no value applies to the property for the method called then the equivalent value will be null


### Example

```
  var moveHistory: ObservableStack<Move>()
  moveHistory.observe(this, Observer {moveHistory ->
      undoButton?.isEnabled = moveHistory.size > 0
      resetButton?.isEnabled = moveHistory.size > 0
  })
  
  


## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

