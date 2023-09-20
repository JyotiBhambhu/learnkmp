//
//  LaunchViewModel.swift
//  iosApp
//
//  Created by Jyoti on 15/09/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import data

class LaunchViewModel: ObservableObject{
    @Published var state: [DataRocketLaunch]?
    @Published var error: String?
    
    init() {
        RocketLaunchesUseCaseHelper().invoke{ rocketLaunches, error in
            DispatchQueue.main.async {
                if rocketLaunches != nil {
                    self.state = rocketLaunches
                }else{
                    self.error = error?.localizedDescription ?? "error"
                }
            }
        }
    }
}
