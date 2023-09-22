import SwiftUI
import shared

@main
struct iOSApp: App {
    let myOrder = Order()
    let intSet: Set<Int> = [1, 2, 3]
    
    let myFriendlyOrder = FriendlyOrder()
    
    init() {
        IOSModuleKt.doInitKoin()
        
        //Rename example
        ExampleKt.findElementInList(elem: 1, list: [1, 2, 3])
        IOSFriendlyExampleKt.find(1, [1, 2, 3])
        
        //Set, map issues
        myOrder.setOptions(options: ExampleKt.options)
        myOrder.setOptions(options: intSet)
        
        //Friendly Map, set
        myFriendlyOrder.setFriendlyOptions(optionSet: IOSFriendlyExampleKt.option2Set)
        myFriendlyOrder.setFriendlyOptions(optionMap: IOSFriendlyExampleKt.option2Map)
//        myFriendlyOrder.setFriendlyOptions(optionSet: intSet)
        
    }

	var body: some Scene {
		WindowGroup {
            LaunchScreen()
		}
	}
}

class OptionImpl: Option{
    var id: String
    
    init(id: String) {
        self.id = id
    }
//
//    let set: Set<Option> = [OptionImpl(id: "A")]
//
//    func areEqual(a: Option, b: Option){
//        return a == b
//    }
}
