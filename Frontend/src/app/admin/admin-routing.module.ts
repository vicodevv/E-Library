import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { BooksComponent } from './components/books/books.component';

const routes: Routes = [
    { path: 'admin', component: HomeComponent },
    { path: 'admin/sign-in', component: SignInComponent },
    { path: 'admin/sign-up', component: SignUpComponent },
    { path: 'admin/books', component: BooksComponent },
    //{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AdminRoutingModule { }
