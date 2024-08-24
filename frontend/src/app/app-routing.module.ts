import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { RegisterUserComponent } from "./register-user/register-user.component";
import { UserListComponent } from "./user-list/user-list.component";
import { UserDetailsComponent } from "./user-details/user-details.component";
import { UpdateUserComponent } from "./update-user/update-user.component";

const routes: Routes = [
    { path: '', redirectTo: '/register', pathMatch: "full"},
    { path: 'register', component: RegisterUserComponent },
    { path: 'user-list', component: UserListComponent },
    { path: 'user-details/:username', component: UserDetailsComponent }, 
    { path: 'update-user/:username', component: UpdateUserComponent}
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingMModule{ }