export interface Book{
    id: string;
    title: string;
    author: string;
    publishedDate: string;
    metacritic: number;
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
