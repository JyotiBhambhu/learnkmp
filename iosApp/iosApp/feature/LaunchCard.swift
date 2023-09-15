//
//  LaunchCard.swift
//  iosApp
//
//  Created by Jyoti on 15/09/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import SDWebImageSwiftUI

struct LaunchCard: View {
    
    let launchItem: RocketLaunch
    
    init(launchItem: RocketLaunch) {
        self.launchItem = launchItem
    }
    
    var body: some View{
        HStack(alignment: .center){
            WebImage(url: URL(string: launchItem.links?.patch?.small ?? ""))
                        .resizable()
                        .placeholder(Image(systemName: "photo")) // Placeholder Image
                        .placeholder {
                            Rectangle().foregroundColor(.white)
                        }
                        .indicator(.activity)
                        .transition(.fade(duration: 0.5))
                        .scaledToFill() // 1
                        .frame(width: 80, height: 80, alignment: .center)
            VStack(alignment: .leading){
                Text(launchItem.missionName ?? "")
                    .font(.body)
                    .frame(alignment: .center)
                Text(String(launchItem.details ?? ""))
                    .frame(alignment: .trailing)
            }
            .padding(.top, 8)
            .padding(.leading, 8)
            .padding(.trailing, 8)
            .padding(.bottom, 12)
        }
        .frame(
              minWidth: 0,
              maxWidth: .infinity,
              minHeight: 0,
              maxHeight: .infinity,
              alignment: .topLeading
            )
        .background(Color.white)
        .cornerRadius(8)
        .shadow(radius: 5)
        
        
    }
}
