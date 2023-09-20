//
//  DetailScreen.swift
//  iosApp
//
//  Created by Jyoti on 15/09/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import data
import SDWebImageSwiftUI

struct DetailScreen: View {
    let launchInfo: DataRocketLaunch
    
    init(launchInfo: DataRocketLaunch) {
        self.launchInfo = launchInfo
    }
    
    var body: some View{
        VStack(alignment: .center){
            WebImage(url: URL(string: launchInfo.links?.patch?.large ?? ""))
                        .resizable()
                        .placeholder(Image(systemName: "photo")) // Placeholder Image
                        .placeholder {
                            Rectangle().foregroundColor(.white)
                        }
                        .indicator(.activity)
                        .transition(.fade(duration: 0.5))
                        .scaledToFill() // 1
                        .frame(width: 240, height: 240, alignment: .center)
                Text(launchInfo.missionName ?? "")
                    .font(.body)
                    .frame(alignment: .center)
                Text(String(launchInfo.details ?? ""))
                    .frame(alignment: .trailing)
        }
        .frame(
              minWidth: 0,
              maxWidth: .infinity,
              minHeight: 0,
              maxHeight: .infinity,
              alignment: .topLeading
            )
        .padding(16)
        .background(Color.white)
        .cornerRadius(8)
        .shadow(radius: 5)
        
        
    }
}
