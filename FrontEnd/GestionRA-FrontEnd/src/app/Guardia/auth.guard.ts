import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { StorageServiceService } from '../Servicios/storage-service.service';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const storageService = inject(StorageServiceService);
  const token = storageService.getToken();

  if (!token){
    router.navigate(['']);
    return false;
  }

  const allowedRoles = route.data['roles'] as string[];
  if (allowedRoles && allowedRoles.length > 0) {
    const userRoles = storageService.getRoles() || [];
    const hasRole = userRoles.some(role => allowedRoles.includes(role));
    if (!hasRole) {
      router.navigate(['']); // O a una página de acceso denegado
      return false;
    }
  }

  return true;
};
