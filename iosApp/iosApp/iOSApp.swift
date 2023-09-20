import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        IOSModuleKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
            LaunchScreen()
		}
	}
}
