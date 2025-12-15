import { CSSProperties } from 'react';

interface SearchHereButtonProps {
    onClick: () => void;
}

export default function SearchHereButton({ onClick }: SearchHereButtonProps) {
    const buttonStyle: CSSProperties = {
        position: 'absolute',
        bottom: '90px',
        left: '50%',
        transform: 'translateX(-50%)',
        backgroundColor: 'white',
        border: 'none',
        borderRadius: '24px',
        padding: '12px 24px',
        boxShadow: '0 2px 12px rgba(0, 0, 0, 0.15)',
        cursor: 'pointer',
        display: 'flex',
        alignItems: 'center',
        gap: '8px',
        zIndex: 200,
        fontSize: '15px',
        fontWeight: '500',
        color: '#333',
        transition: 'all 0.2s ease',
    };

    const iconStyle: CSSProperties = {
        width: '18px',
        height: '18px',
        color: '#1e88e5',
    };

    return (
        <button 
            style={buttonStyle}
            onClick={onClick}
            onMouseEnter={(e) => {
                e.currentTarget.style.transform = 'translateX(-50%) scale(1.05)';
                e.currentTarget.style.boxShadow = '0 4px 16px rgba(0, 0, 0, 0.2)';
            }}
            onMouseLeave={(e) => {
                e.currentTarget.style.transform = 'translateX(-50%) scale(1)';
                e.currentTarget.style.boxShadow = '0 2px 12px rgba(0, 0, 0, 0.15)';
            }}
        >
            <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                <circle cx="11" cy="11" r="8" strokeWidth="2" />
                <path d="m21 21-4.35-4.35" strokeWidth="2" strokeLinecap="round" />
            </svg>
            현재 위치에서 검색
        </button>
    );
}