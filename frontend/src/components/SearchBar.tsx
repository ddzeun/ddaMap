import { CSSProperties } from 'react';

export default function SearchBar() {
    const containerStyle: CSSProperties = {
        position: 'absolute',
        top: '20px',
        left: '50%',
        transform: 'translateX(-50%)',
        width: 'calc(100% - 40px)',
        maxWidth: '500px',
        zIndex: 1000,
    };

    const searchBarStyle: CSSProperties = {
        width: '100%',
        height: '50px',
        backgroundColor: 'white',
        borderRadius: '25px',
        boxShadow: '0 2px 12px rgba(0, 0, 0, 0.15)',
        display: 'flex',
        alignItems: 'center',
        padding: '0 20px',
        boxSizing: 'border-box',
    };

    const iconStyle: CSSProperties = {
        width: '20px',
        height: '20px',
        marginRight: '12px',
        color: '#888',
    };

    const inputStyle: CSSProperties = {
        flex: 1,
        border: 'none',
        outline: 'none',
        fontSize: '15px',
        backgroundColor: 'transparent',
    };

    return (
        <div style={containerStyle}>
            <div style={searchBarStyle}>
                <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                    <circle cx="11" cy="11" r="8" strokeWidth="2" />
                    <path d="m21 21-4.35-4.35" strokeWidth="2" strokeLinecap="round" />
                </svg>
                <input
                    type="text"
                    placeholder="정류소, 주소 검색"
                    style={inputStyle}
                />
            </div>
        </div>
    );
}