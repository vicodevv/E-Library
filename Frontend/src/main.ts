import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AdminModule } from './app/admin/admin.module';
import { CustomerModule } from './app/customers/customer.module';



platformBrowserDynamic().bootstrapModule(AdminModule)
  .catch(err => console.error(err));
