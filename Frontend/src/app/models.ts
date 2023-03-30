export interface Books{
    id: number;
    title: string;
    author: string;
    publishedDate: string;
    category: Array<string>;
    packageType: Array<string>;
    availableQuantity: number;
    totalQuantity: number;
    coverPage: string;
}

export interface APIResponse<T> {
    results: Array<T>;
}
