# Observable Collections
Observable Collections for Android Kotlin apps which will callback on every action that changes the contents of the collection 

Callback is triggered for each action that changes the contents of the collection such as add, delete, clear etc.  
The callback will NOT be triggered if the object itself in the collection is mutable and it is changed directly. 

## Getting Started

This is a library project and should be downloaded and added as a module in your application or linked to via Gradle.
See below for instructions.

### Prerequisites
```
Android Studio
Kotlin
```

### Installing

The library can be included in your application in one of two ways:

## Source
Download the zip file and unpack into your project directory or checkout.
```
Go to File->Project Structure.
Ensure that the module is included in the modules of the application.

Go to the Dependecies tab and and click on the "+" sign. Select Module Dependency.
From the list of modules select "ObservableCollections"
```
## Gradle
To include via gradle add the following to the dependencies in the gradle file of your module.

    implementation 'il.co.theblitz:observablecollections:1.4.0' (For a specific version)
or 

    implementation 'il.co.theblitz:observablecollections:+'     (For latest version) 
    
Make sure you have jcenter() included in your list of repositories in your project level gradle.

## Usage

### Connecting Observer
Usage is simple and is the same as other LiveData.
Just "Observe" the object as you would any other.
The observer will receive the collection object as the parameter when called.

Note that when the Observer is assigned to the collection an immediate callback occurs with the last value and action. 
This is the default behaviour of LiveData.
This can be overridden by passing the value "false" to "skipCurrentValueCall" when instantiating the collection.


### Callback Values

You can check the object to see what action was performed that caused the change, what was passed to it and what was the result.
The following properties are available for standard collection objects:
```
action:             The action performed. A full list is available in the enum ObservableCollectionsAction
actionElement:      Element on which the action was performed. For example, the element that was passed to an add or delete method
actionElements:     Element collection on which the action was performed. For example, the collection passed to an addall method
actionInt:          Int value on which the action was performed. For example, the int value passed to a removeAt method
removedElements:    Element collection of all elements removed indirectly. For example, elements removed by removeIf and retainAll
resultElement:      The element returned from the method. For example, the element returned from a pop method
resultBoolean:      Boolean returned from the method. For example, boolean returned from an add method. Note that this will always be true if it is not null
resultInt:          Int returned from the method. For example, the number of elements deleted in a drainTo method
```

The following properties are available from map objects:
```
action:             The action performed. A full list is available in the enum ObservableCollectionsAction
actionKey:          Key on which the action was performed. For example, the key that was passed to a remove or put method
actionValue:        Value on which the action was performed. For example, the value that was passed to a method
actionMap:          Key/value pair(s) on which the action was performed. For example, values passed to a putAll method
removedElements:    Element collection of all elements removed indirectly. For example, elements removed by removeIf and retainAll
resultValue:        A value returned from the method. For example, the value returned from a put method
```
The properties will only have relevant values. If no value applies to the property for the method called then the equivalent value will be null.
Furthermore, the values should only be assumed to be correct whilst still in the observe block. They can not be guaranteed to remain unchanged once control is returned to the caller.

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
The callback will happen before control returns from the push method


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

