
this is sample android application with rest api backend in php .

I wanted to develop it to show how the code can be little 

with object oriented programming concepts .

This code show usage of :

1 - two  generic RecyclerView adapter classses without data binding

I used this wonderful gist and modeified it a bit

https://gist.github.com/Plumillon/f85c6be94e2fdaf339b9

a - its implemetation in NormalAdapterActivity

https://github.com/omar-adel/Generic-RecyclerView-Adapters/blob/master/android/RecyclerAdapters/app/src/main/java/omar/apps923/recycleradapters/activities/NormalAdapterActivity.java

b - ( I prefer this way ) 

its implemetation in GenericAdapterActivity

https://github.com/omar-adel/Generic-RecyclerView-Adapters/blob/master/android/RecyclerAdapters/app/src/main/java/omar/apps923/recycleradapters/activities/GenericAdapterActivity.java


2 - generic custom RecyclerView adapter class with data binding 

I used this wonderful class  and modeified it a bit

https://github.com/ravirupareliya/Recyclerview-Generic-Adapter/blob/master/app/src/main/java/com/rrr/genericrecyclerview/adapter/RecyclerAdapter.java

its implemetation in DatabindingAdapterActivity1

https://github.com/omar-adel/Generic-RecyclerView-Adapters/blob/master/android/RecyclerAdapters/app/src/main/java/omar/apps923/recycleradapters/activities/DatabindingAdapterActivity1.java

or in DatabindingAdapterActivity2 ( with another way )

https://github.com/omar-adel/Generic-RecyclerView-Adapters/blob/master/android/RecyclerAdapters/app/src/main/java/omar/apps923/recycleradapters/activities/DatabindingAdapterActivity2.java

 
3 - IonWrapper for calling rest webservices 

it uses this wonderful library 

https://github.com/koush/ion

4 - base model that you can parse json web services and get  responses of it as 

objects or lists of this base model .

5 - empty RecyclerView support .


 