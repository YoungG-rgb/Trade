import Link from 'next/link'

const Header = () => {
    return (
        <header>
            <div>

            </div>
            <nav>
                <Link legacyBehavior  href='/tabs/panel'>Панель</Link>
                <Link legacyBehavior href='/tabs/users'>Пользователи</Link>
                <Link legacyBehavior href='/tabs/items'>Товары</Link>
                <Link legacyBehavior href='/tabs/coupons'>Купоны</Link>
            </nav>
            
        </header>
    )
}

export default Header;