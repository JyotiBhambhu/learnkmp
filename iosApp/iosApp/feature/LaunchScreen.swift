//
//  File.swift
//  iosApp
//
//  Created by Jyoti on 15/09/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LaunchScreen: View {
    
    @ObservedObject var viewModel: LaunchViewModel
    
    init(){
        self.viewModel = LaunchViewModel()
    }
    
    var body: some View{
        NavigationView{
            ZStack{
                if let launches = viewModel.state {
                    List{
                        ForEach(launches, id: \.self.id){ launchInfo in
                            ZStack{
                                VStack{
                                    LaunchCard(launchItem: launchInfo)
                                }
                               
                                NavigationLink(destination: DetailScreen(launchInfo: launchInfo)){
                                    EmptyView()
                                }
                                .opacity(0)
                            }
                        }
                    }.listStyle(PlainListStyle())
                }else{
                    Text(viewModel.error ?? "Loading..")
                }
            }.navigationBarHidden(true)
        }
    }
}
