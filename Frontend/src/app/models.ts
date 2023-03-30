export interface Books{
    id: number;
    title: string;
    author: string;
    publishedDate: string;
    category: Array<Category>;
    packageType: Array<PackageType>;
    availableQuantity: number;
    totalQuantity: number;
    coverPage: string;
}

export interface APIResponse<T> {
    results: Array<T>;
}

interface Category {
    name: string;
}

interface PackageType {
    name: string;
}
