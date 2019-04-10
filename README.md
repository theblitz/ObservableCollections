# Observable Collections
Observable Collectons for Android Kotlin apps which will callback on every action that changes the contents of the collection 

Callback is trigged for each action that changes the contents of the collection such as add, delete, clear etc.  
The callback will NOT be trigged if the object itself in the collection is mutable and it is changed directly. 

## Getting Started

This is a library project and should be downloaded and added as a module in your application.

### Prerequisites
```
Android Studio
Kotlin
```

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


You can check the object to see what action was performed that caused the change, what was passed to it and what was the result.
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


**Note:**

The callback will happen BEFORE control is returned to the code that called the method that made the change. You have to use the above values if you wish to see the values returned from the method.


### Example

```
  var moveHistory: ObservableStack<Move>()
  moveHistory.observe(this, Observer {moveHistory ->
      undoButton?.isEnabled = moveHistory.size > 0
      resetButton?.isEnabled = moveHistory.size > 0
  })
  
  ...
  ...
  ...
  
  moveHistory.push(Move())
```
The callback will happen before control return from the add method


## Authors

* **Jonathan Blitz** - *Initial work* - [theblitz](https://github.com/theblitz)


## License
Copyright 2019 Jonathan Blitz
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## Acknowledgments

* Inspired by repeated questions on StackOverflow

